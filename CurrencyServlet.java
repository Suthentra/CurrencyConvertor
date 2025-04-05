package com.tce.it;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CurrencyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        double amount = Double.parseDouble(request.getParameter("amount"));
        String toCurrency = request.getParameter("currency");

        double converted = 0;
        String symbol = "";

        switch (toCurrency) {
            case "INR":
                converted = amount * 83.2;
                symbol = "₹";
                break;
            case "EUR":
                converted = amount * 0.92;
                symbol = "€";
                break;
            case "JPY":
                converted = amount * 151.6;
                symbol = "¥";
                break;
        }

        // JDBC connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load the JDBC driver

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/currencydb", // Change DB name if needed
                "root",                                   // Your DB username
                ""                                        // Your DB password (if any)
            );

            // Prepare insert statement
            String sql = "INSERT INTO conversions (from_currency, to_currency, amount, result) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "USD"); // Assuming conversion is from USD
            stmt.setString(2, toCurrency);
            stmt.setDouble(3, amount);
            stmt.setDouble(4, converted);

            stmt.executeUpdate();

            stmt.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace(); // For debugging
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>Converted Amount: " + symbol + String.format("%.2f", converted) + "</h3>");
        out.println("<a href='index.html'>Convert Again</a>");
        out.println("</body></html>");
    }
}
