package com.classqr.sistema.commons.service;

public interface ITokenBlackListService {

    void blackListToken(String token);

    boolean isTokenBlackListed(String token);

}
