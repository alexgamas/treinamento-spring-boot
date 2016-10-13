'use strict';

describe('Controller: AvaliacaoCtrl', function () {

  // load the controller's module
  beforeEach(module('treinamentoApp'));

  var AvaliacaoCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    AvaliacaoCtrl = $controller('AvaliacaoCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(AvaliacaoCtrl.awesomeThings.length).toBe(3);
  });
});
