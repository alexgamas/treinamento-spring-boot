'use strict';

/**
 * @ngdoc overview
 * @name treinamentoApp
 * @description
 * # treinamentoApp
 *
 * Main module of the application.
 */
angular
	.module('treinamentoApp', ['ngAnimate', 'ngCookies', 'ngMessages', 'ngResource', 'ngRoute', 'ngSanitize', 'ngTouch'])
	.config(function ($routeProvider) {
		$routeProvider.when('/', {
			templateUrl: 'views/main.html',
			controller: 'MainCtrl',
			controllerAs: 'main'
		}).when('/inscricao', {
			templateUrl: 'views/inscricao/list.html',
			controller: 'InscricaoCtrl',
			controllerAs: 'inscricao'
		}).when('/inscricao/new', {
			templateUrl: 'views/inscricao/new.html',
			controller: 'InscricaoCtrl',
			controllerAs: 'inscricao'
		}).when('/inscricao/:id', {
			templateUrl: 'views/inscricao/edit.html',
			controller: 'InscricaoCtrl',
			controllerAs: 'inscricao'
		}).when('/avaliacao', {
			templateUrl: 'views/avaliacao.html',
			controller: 'AvaliacaoCtrl',
			controllerAs: 'avaliacao'
		}).otherwise({
			templateUrl: 'views/error/404.html'
		});
		/*
		.when('/about', {
		templateUrl: 'views/about.html',
		controller: 'AboutCtrl',
		controllerAs: 'about'
		})
		*/

	});
