angular.module("app")
    .constant("managerUrl", "/manager")
    .controller("ManagerController", function ($scope, $http, managerUrl,ActualUserFactory) {

        $scope.manager = ActualUserFactory.getData();
        
        $scope.getManager = function (id) {
            $http.get(managerUrl+"/"+id).success(function (data) {
                    $scope.manager = data;
                })
                .error(function (error) {
                    $scope.error = error;
                })
        };
        
        $scope.updateManager = function (manager) {
            $http.put(managerUrl, manager);
            $scope.getManager();
        };

        $scope.addEmployee = function (newEmployee, supervisor) {
            supervisor.employees.push(newEmployee);
            $http.put(managerUrl, $scope.manager);

            $scope.getManager();
        };

    });