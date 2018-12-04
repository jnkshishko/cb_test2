package servlets;

import car.CarModule;
import dto.CountDTO;
import dto.ReportDTO;
import fine.FineModule;
import fine.model.Fine;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ReportServlet", urlPatterns = "/report")
public class ReportServlet extends HttpServlet {

    @EJB
    private CarModule carModule;

    @EJB
    private FineModule fineModule;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<CountDTO> countDTOS = carModule.getFinesIds(5);
        List<ReportDTO> reportDTOS = new ArrayList<>();
        Fine fine = new Fine();
         for(CountDTO countDTO:countDTOS) {
             fine = fineModule.getFineById(countDTO.getFineId());
             ReportDTO reportDTO = new ReportDTO();
             reportDTO.setCount(countDTO.getCount());
             reportDTO.setType(fine.getType());
             reportDTO.setCost(fine.getCost());
             reportDTOS.add(reportDTO);
         }

        req.setAttribute("list", reportDTOS);
        req.getRequestDispatcher("report.jsp").forward(req, resp);

    }
}
