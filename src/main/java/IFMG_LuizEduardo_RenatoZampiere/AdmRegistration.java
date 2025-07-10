package IFMG_LuizEduardo_RenatoZampiere;

import IFMG_LuizEduardo_RenatoZampiere.model.entities.User;
import IFMG_LuizEduardo_RenatoZampiere.model.enums.UserType;
import org.springframework.jdbc.datasource.init.ScriptStatementFailedException;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import IFMG_LuizEduardo_RenatoZampiere.utils.InputOutputPers;

public class AdmRegistration {
    public static void main(String[] args){

        InputOutputPers console = new InputOutputPers();

        if(! console.input("Senha: ").equals("jj")){
            console.print("Senha inválida. Aplicação encerrda.");
            System.exit(0);
        }

        String url = "jdbc:postgresql://localhost:5432/hotelBao";
        String user = "postgres";
        String password = "root";

        String sql = """
            SELECT id, address, address_number, district, email, password, phone, real_name, registration_date, user_name, user_type
            FROM public.user_table;
           """;

        List<User> lista = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();


            while (rs.next()) {
                // Exemplo: acessando dados por nome da coluna
                User userData = new User();

                userData.setId(rs.getLong("id"));
                userData.setRealName(rs.getString("real_name"));
                userData.setUserName(rs.getString("user_name"));
                lista.add(userData);
            }

        } catch (SQLException e) {
            System.exit(1);
        }

        int i = 0;
        for(User useri : lista){
            System.out.println("Indice: "+ i + "  nome real: " + useri.getRealName() + "username" + useri.getUsername());
            i++;
        }

        String id = console.input("Digite o indice da lista, do usuário que se tornará ADM:");
        int id_l = Integer.parseInt(id);


        sql = "UPDATE public.user_table SET user_type = " +  "'" + UserType.ADMIN.getValue().toLowerCase() + "'" + " WHERE id = " + lista.get(id_l).getId();
        System.out.println(sql);

        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
        }catch (SQLException e){
            console.print(e.toString());
        }


    }
}
