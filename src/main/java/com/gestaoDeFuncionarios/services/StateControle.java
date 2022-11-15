package com.gestaoDeFuncionarios.services;

import com.gestaoDeFuncionarios.presenter.StateViews;

public class StateControle {

    private StateViews estados = null;

    public void manterFuncionarioStateView() {
        estados.manterFuncionarioStateView();

    }

    public void visualizarFuncionarioStateView() {
        //estados.visualizarFuncionarioStateView();
    }

    public void setEstados(StateViews estados) {
        this.estados = estados;
    }

}
