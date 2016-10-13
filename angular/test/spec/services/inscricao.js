'use strict';

describe('Service: inscricao', function () {

  // load the service's module
  beforeEach(module('treinamentoApp'));

  // instantiate service
  var inscricao;
  beforeEach(inject(function (_inscricao_) {
    inscricao = _inscricao_;
  }));

  it('should do something', function () {
    expect(!!inscricao).toBe(true);
  });

});
