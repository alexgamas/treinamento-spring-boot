'use strict';

/**
 * @ngdoc function
 * @name treinamentoApp.controller:AvaliacaoCtrl
 * @description
 * # AvaliacaoCtrl
 * Controller of the treinamentoApp
 */
angular.module('treinamentoApp').controller('AvaliacaoCtrl', function ($scope, $http) {

	$scope.recordsPerPage = [];

	$http.get('http://localhost:3000/inscricoes').then(function (response) {
		$scope.inscricoes = response.data;
	});

	$scope.edit = function(id){

	};



});
