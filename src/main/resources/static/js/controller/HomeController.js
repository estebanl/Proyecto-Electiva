angular.module("app")
    .constant("registerUrl", "/manager")
    .constant("loginUrl", "/home")
    .controller("HomeController", function ($scope, $http, $location, registerUrl, loginUrl,ActualUserFactory) {

        $scope.infoRegister = "";

        $scope.registerUser = function (newUser) {
            $http.post(registerUrl, newUser)
                .success(function (data) {
                    $scope.infoRegister = "Register success";
                    $location.path("/login");
                })
                .error(function (error) {
                    $scope.infoRegister = "Register fail" + error;
                });
        };
        $scope.loginUser = function (user) {
            $http.post(loginUrl, user)
                .success(function (data) {
                    $scope.nameUser = data.name;
                    $scope.infoRegister = "Login succes" + data.role;
                    if (data.role == "Manager") {
                        ActualUserFactory.addData(data);
                        $location.path("/manager");
                    }
                    else if (data.role == "Supervisor") {
                        ActualUserFactory.addData(data);
                        $location.path("/supervisor");
                    }
                    else {
                        $location.path("/");
                    }
                })
                .error(function (error) {
                    $scope.infoRegister = "Login fail" + error;
                });
        };
    }); 