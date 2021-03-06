// Creación del módulo
var angularRoutingApp = angular.module('angularFormLogin', ['ngRoute','naif.base64']);

// Configuración de las rutas
angularRoutingApp.config(function($routeProvider) {

    $routeProvider
        .when('/', {
            templateUrl : 'resources/pages/login.html',
            controller  : 'mainController'
        })
        .when('/welcome', {
            templateUrl : 'resources/pages/welcome.html',
            controller  : 'welcomeController'
        })
        .otherwise({
            redirectTo: '/'
        });
});