package org.example.demo1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.demo1.dao.PrescriptionDAOImpl;
import org.example.demo1.models.Prescription;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "prescription", value ="/prescription")
public class PrescriptionServlet extends HttpServlet {

    private PrescriptionDAOImpl bloup;

    private List<Prescription> demission = new ArrayList<>();


    @Override
    public void init() throws ServletException {
        bloup = new PrescriptionDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String ids = req.getParameter("conId");
        int id = 0;

        System.out.println(demission);

        if (ids != null) {
            int patId = Integer.parseInt(req.getParameter("patId"));
            id = Integer.parseInt(ids);
            demission = bloup.ReadById(id);
            req.setAttribute("conId", id);
            req.setAttribute("patId", patId);
            req.setAttribute("prescriptions", demission);
            req.getRequestDispatcher("prescription.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("patient.jsp").forward(req, resp);
        }
    }
}

