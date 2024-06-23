package com.aelson.todolist.helpers;

public enum StatusTarefa {
    iniciada("iniciada"),
    finalizada("finalizada"),
    cancelada("cancelada"),
    pausada("pausada");

    private String status;

    StatusTarefa(String status){
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }
}
