'use strict';

describe('Controller: InscricaoCtrl', function () {

  // load the controller's module
  beforeEach(module('treinamentoApp'));

  var InscricaoCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    InscricaoCtrl = $controller('InscricaoCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(InscricaoCtrl.awesomeThings.length).toBe(3);
  });
});
