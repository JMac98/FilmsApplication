package com.sparta.team3.services;

import com.sparta.team3.beans.ActorBean;
import com.sparta.team3.beans.FilmBean;
import com.sparta.team3.components.ResultList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class WelcomeFilms {

    @Inject
    private ActorBean actorBean;
    @Inject
    private FilmBean filmBean;

    private List<Object> objectList;
    private String radioOption;
    private String userInput;

    public List<Object> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<Object> objectList) {
        this.objectList = objectList;
    }

    public String getRadioOption() {
        return radioOption;
    }

    public void setRadioOption(String radioOption) {
        this.radioOption = radioOption;
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public String getList() {
        ResultList resultList = new ResultList();
        if (radioOption.equals("1")) {
            resultList.setList(actorBean.displayActors(userInput));
            return "listActors";
        } else {
            resultList.setList(filmBean.displayFilms(userInput));
            return "listFilms";
        }
    }
}

