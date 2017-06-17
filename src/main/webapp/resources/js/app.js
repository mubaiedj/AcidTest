// Creación del módulo
var angularRoutingApp = angular.module('angularFormLogin', ['ngRoute']);

// Configuración de las rutas
angularRoutingApp.config(function($routeProvider) {

    $routeProvider
        .when('/', {
            templateUrl : 'resources/pages/login	.html',
            controller  : 'mainController'
        })
        .otherwise({
            redirectTo: '/'
        });
});