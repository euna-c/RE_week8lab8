package servlets;


import services.NoteService;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.List;
import models.Note;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 784564
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        NoteService ns = new NoteService();

        List<Note> notes = ns.getAll();
        request.setAttribute("notes", notes);

        String action = (String) request.getParameter("action");
        if (action == null) {
            request.setAttribute("view", false);

        }
        getServletContext().getRequestDispatcher("/WEB-INF/notes.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        NoteService ns = new NoteService();

        String title = (String) request.getParameter("titleTxt");
        String contents = (String) request.getParameter("contentsTxt");
        String action = (String) request.getParameter("action");

        switch (action) {
            case "add":
                request.setAttribute("view", false);
                ns.insert(contents, title);
                break;
            case "show":
                request.setAttribute("view", true);
                request.setAttribute("note", ns.get(Integer.parseInt(request.getParameter("id"))));
                break;
            case "save":
                request.setAttribute("view", true);
                //request.setAttribute("view", false)
                ns.update(Integer.valueOf(request.getParameter("id")), title, contents);
                request.setAttribute("note", ns.get(Integer.parseInt(request.getParameter("id"))));
                break;
            case "delete":
                request.setAttribute("view", true);
                ns.delete(Integer.valueOf(request.getParameter("id")));
                break;
        }

        List<Note> notes = ns.getAll();
        request.setAttribute("notes", notes);

        getServletContext().getRequestDispatcher("/WEB-INF/notes.jsp").forward(request, response);
    }

}
