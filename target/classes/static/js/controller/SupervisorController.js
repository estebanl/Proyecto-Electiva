angular.module("app")
    .constant("supervisorUrl", "/supervisor")
    .controller("SupervisorController", function ($scope, $http, supervisorUrl, ActualUserFactory) {

        $scope.SingleSupervisor = ActualUserFactory.getData();
        
        $scope.getSupervisor = function (id) {
            $scope.selectEmployee = {};
            $http.get(supervisorUrl + "/" + id)
                .success(function (data) {
                    $scope.SingleSupervisor = data;
                    $scope.selectSupervisor = data;

                })
                .error(function (error) {
                    $scope.error = error;
                });
        };

        $scope.createSupervisor = function (supervisor, manager) {
            supervisor.manager = manager;
            $http.post(supervisorUrl, supervisor)
                .success(function (data) {
                    $scope.getManager(manager.id);
                    $scope.newSupervisor={};
                })
                .error(function (error) {
                    $scope.error = error;
                });
        };

        $scope.deleteSupervisor = function (supervisor) {
            $http.delete(supervisorUrl + "/" + supervisor.id).then(function () {

            });
        };

        $scope.addEmployee = function (newEmployee) {
            $scope.SingleSupervisor.employees.push(newEmployee);
            $http.put(supervisorUrl, $scope.SingleSupervisor);
        };
        
        $scope.selectedSupervisor = function (supervisor) {
            $scope.getSupervisor(supervisor.id);

        };
    });