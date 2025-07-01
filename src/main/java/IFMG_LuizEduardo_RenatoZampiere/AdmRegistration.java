package IFMG_LuizEduardo_RenatoZampiere;

import IFMG_LuizEduardo_RenatoZampiere.model.enums.UserType;
import org.springframework.jdbc.datasource.init.ScriptStatementFailedException;

import java.io.Console;
import java.sql.*;
import java.time.LocalDate;

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

        Connection conn = null;
        String sql = "INSERT INTO user_table( " +
                "address, address_number, district, email, password, phone, real_name, registration_date, user_name, user_type) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            conn = DriverManager.getConnection(url, user, password);
            if (conn != null) {
                console.print("Conexão estabelecida com sucesso!");
            } else {
                console.print("Falha na conexão.");
            }

            PreparedStatement pstmt = conn.prepareStatement(sql);

            String rua = console.input(">> Rua e Bairro: ");
            pstmt.setString(1, rua);

            String numero = console.input(">> Número da residência: ");
            pstmt.setString(2, numero);

            String cidade = console.input(">> Cidade: ");
            pstmt.setString(3, cidade);

            String email = console.input(">> e-mail: ");
            pstmt.setString(4, email);

            String senha = console.input(">> senha: ");
            pstmt.setString(5, senha);

            String tel = console.input(">> Telefone: ");
            pstmt.setString(6, tel);

            String nome = console.input(">> Nome real: ");
            pstmt.setString(7, nome);

            String username = console.input(">> User name (usado para loguin): ");
            pstmt.setString(9, username);

            pstmt.setString(10, UserType.ADMIN.getValue());
            pstmt.setDate(8, Date.valueOf(LocalDate.now()));

            int linhas = pstmt.executeUpdate();
            console.print("Inserção realizada. Linhas afetadas: " + linhas);

        }
        catch (SQLException e) {
            console.print("Erro ao conectar: " + e.getMessage());
            System.exit(1);
        }
        catch (ScriptStatementFailedException e){
            console.print("Erro no código sql");
            System.exit(0);
        }
    }
}
