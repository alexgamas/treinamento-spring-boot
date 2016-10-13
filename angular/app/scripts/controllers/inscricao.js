'use strict';

/**
 * @ngdoc function
 * @name treinamentoApp.controller:InscricaoCtrl
 * @description
 * # InscricaoCtrl
 * Controller of the treinamentoApp
 */

angular.module('treinamentoApp').controller('InscricaoCtrl', function ($scope, $location, $routeParams) {
	$scope.save = function() {
		alert($scope.cadastro);
	};
});
