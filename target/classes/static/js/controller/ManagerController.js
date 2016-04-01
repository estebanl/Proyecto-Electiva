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

        $scope.generatePDF = function() {
            var imprimir = document.getElementById("imprimir");
            var pdf = new jsPDF('p', 'pt', 'letter');
            source = imprimir;
            specialElementHandlers = {
                '#bypassme': function(element, renderer) {
                    return true
                }
            };
            margins = {
                top: 80,
                bottom: 60,
                left: 40,
                width: 522
            };
            pdf.fromHTML(
                source,
                margins.left,
                margins.top, {
                    'width': margins.width,
                    'elementHandlers': specialElementHandlers
                },
                enviar = function(dispose) {
                    pdf.save('Test.pdf');
                }
                , margins);
        };

    });