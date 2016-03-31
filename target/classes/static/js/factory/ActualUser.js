angular.module("ActualUser",[])
.factory("ActualUserFactory",function () {
    var userData = {};
    return {
        addData: function (data) {
            userData = data;
        },
        getData: function () {
            return userData;
        }
    }
});