package servlets;

import car.CarModule;
import car.model.Car;
import common.exceptions.CarNotFoundException;
import dto.AnswerDTO;
import fine.model.Fine;
import owner.OwnerModule;
import owner.model.Owner;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static common.ValidationUtils.isOwnerExists;
import static dto.AssemblerAnswerDTO.assemblerAnswerDTO;

@WebServlet(name = "SearchServlet", urlPatterns = "/")
public class SearchServlet extends HttpServlet {

    @EJB
    private OwnerModule ownerModule;

    @EJB
    private CarModule carModule;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String gosnumber = req.getParameter("gosnumber");
        String fullName = req.getParameter("fullName");

        List<Owner> owners = null;

        List<AnswerDTO> answerDTOS = new ArrayList<>();
        Car car = new Car();
        Owner owner = new Owner();
        Fine fine = new Fine();
        if(!"".equals(gosnumber) && "".equals(fullName)) {
            try {
                car = carModule.getCarByGosnumber(gosnumber);
                if(car != null){
                    owner = car.getOwner();
                    fine = car.getFine();

                    answerDTOS.add(assemblerAnswerDTO(car, owner, fine));
                    req.setAttribute("answers", answerDTOS);
                    req.getRequestDispatcher("index.jsp").forward(req, resp);
                }
            } catch (CarNotFoundException e) {
                e.printStackTrace();
            }
        } else if(!"".equals(fullName) && "".equals(gosnumber)) {
            owners = ownerModule.searchOwner(fullName);
            for(Owner o:owners){
                if(o.getCars().size() > 0) {
                    for(Car c: o.getCars()){

                        Fine f = c.getFine();
                        answerDTOS.add(assemblerAnswerDTO(c, o, f));
                    }
                }
            }
            req.setAttribute("answers", answerDTOS);
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else {
            try {
                car = carModule.getCarByGosnumber(gosnumber);
                if(car != null) {
                    owner = car.getOwner();
                    if(isOwnerExists(fullName, owner)){

                        Fine f = car.getFine();
                        answerDTOS.add(assemblerAnswerDTO(car, owner, f));
                    }
                }
                req.setAttribute("answers", answerDTOS);
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            } catch (CarNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
