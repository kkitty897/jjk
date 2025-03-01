import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

http://localhost:8080/YourProjectName/CakeServlet?cakeType=chocolate
public class CakeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Store recipes in a HashMap for easy retrieval
    private static final Map<String, String> recipes = new HashMap<>();
    
    static {
        recipes.put("chocolate", 
            "1. Mix flour, cocoa powder, sugar.<br>2. Add eggs, milk, and butter.<br>3. Bake at 180°C for 30 mins.");
        recipes.put("vanilla", 
            "1. Mix flour, sugar, vanilla extract.<br>2. Add eggs and milk.<br>3. Bake at 175°C for 35 mins.");
        recipes.put("strawberry", 
            "1. Mix flour, sugar, strawberry puree.<br>2. Add eggs and butter.<br>3. Bake at 180°C for 25 mins.");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String cakeType = request.getParameter("cakeType");
        String recipe = recipes.getOrDefault(cakeType, "Recipe not found.");

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Cake Recipe</title>");
        out.println("<link rel='stylesheet' href='styles.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class='container'>");
        out.println("<h1>Recipe for " + capitalize(cakeType) + " Cake</h1>");
        out.println("<p>" + recipe + "</p>");
        out.println("<a href='index.html' class='btn'>Go Back</a>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }

    // Helper function to capitalize the first letter of the cake type
    private String capitalize(String str) {
        if (str == null || str.isEmpty()) return "Unknown";
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
