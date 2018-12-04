package dto;

import car.model.Car;
import fine.model.Fine;
import owner.model.Owner;

public class AssemblerAnswerDTO {

    public static AnswerDTO assemblerAnswerDTO(Car car, Owner owner, Fine fine){

        AnswerDTO answerDTO = new AnswerDTO();
        answerDTO.setGosnumber(car.getGosnumber());
        answerDTO.setMark(car.getMark());
        answerDTO.setModel(car.getModel());

        answerDTO.setOwnerLastname(owner.getLastname());
        answerDTO.setOwnerFirstname(owner.getFirstname());
        answerDTO.setOwnerMiddlename(owner.getMiddlename());

        answerDTO.setTypeOfFine(fine.getType());
        answerDTO.setCostOfFine(fine.getCost());

        return answerDTO;

    }

}
