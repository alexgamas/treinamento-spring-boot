'use strict';

/**
 * @ngdoc function
 * @name treinamentoApp.controller:InscricaoCtrl
 * @description
 * # InscricaoCtrl
 * Controller of the treinamentoApp
 */

angular.module('treinamentoApp').controller('InscricaoCtrl', function ($scope, $location, $routeParams, $http) {
	$scope.save = function() {
		$http.post('http://localhost:3000/inscricoes', $scope.inscricao);
	};
});
