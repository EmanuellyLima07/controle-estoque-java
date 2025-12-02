package main;

import main.dao.*;
import main.model.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EletronicoDAO eleDao = new EletronicoDAO();
        RoupaDAO roupaDao = new RoupaDAO();
        PerecivelDAO perDao = new PerecivelDAO();
        FerramentaDAO ferDao = new FerramentaDAO();

        int op;

        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1 - Eletrônicos");
            System.out.println("2 - Roupas");
            System.out.println("3 - Perecíveis");
            System.out.println("4 - Ferramentas");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1: menuEletronico(sc, eleDao); break;
                case 2: menuRoupa(sc, roupaDao); break;
                case 3: menuPerecivel(sc, perDao); break;
                case 4: menuFerramenta(sc, ferDao); break;
                case 0: System.out.println("Saindo..."); break;
                default: System.out.println("Opção inválida!");
            }

        } while (op != 0);

        sc.close();
    }


    // ===================== MENU ELETRÔNICO =======================

    public static void menuEletronico(Scanner sc, EletronicoDAO dao) {
        int op;

        do {
            System.out.println("\n=== MENU ELETRÔNICO ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Remover");
            System.out.println("0 - Voltar");

            op = Integer.parseInt(sc.nextLine());

            try {
                switch (op) {
                    case 1:
                        Eletronico e = new Eletronico();

                        System.out.print("Nome: ");
                        e.setNome(sc.nextLine());

                        System.out.print("Marca: ");
                        e.setMarca(sc.nextLine());

                        System.out.print("Modelo: ");
                        e.setModelo(sc.nextLine());

                        System.out.print("Garantia (meses): ");
                        e.setGarantiaMeses(Integer.parseInt(sc.nextLine()));

                        System.out.print("Quantidade: ");
                        e.setQuantidade(Integer.parseInt(sc.nextLine()));

                        System.out.print("Preço: ");
                        e.setPreco(Double.parseDouble(sc.nextLine().replace(",", ".")));

                        dao.inserir(e);
                        System.out.println("Eletrônico cadastrado!");
                        break;

                    case 2:
                        dao.listarTodos().forEach(System.out::println);
                        break;

                    case 3:
                        System.out.print("ID: ");
                        int idBuscar = Integer.parseInt(sc.nextLine());
                        Eletronico ee = dao.buscarPorId(idBuscar);
                        System.out.println(ee != null ? ee : "Não encontrado.");
                        break;

                    case 4:
                        System.out.print("ID: ");
                        int idRemover = Integer.parseInt(sc.nextLine());
                        dao.remover(idRemover);
                        System.out.println("Removido.");
                        break;
                }

            } catch (Exception ex) {
                System.out.println("Erro: " + ex.getMessage());
            }

        } while (op != 0);
    }


    // ======================== MENU ROUPA =========================

    public static void menuRoupa(Scanner sc, RoupaDAO dao) {
        int op;

        do {
            System.out.println("\n=== MENU ROUPA ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Remover");
            System.out.println("0 - Voltar");

            op = Integer.parseInt(sc.nextLine());

            try {
                switch (op) {
                    case 1:
                        Roupa r = new Roupa();

                        System.out.print("Nome: ");
                        r.setNome(sc.nextLine());

                        System.out.print("Marca: ");
                        r.setMarca(sc.nextLine());

                        System.out.print("Cor: ");
                        r.setCor(sc.nextLine());

                        System.out.print("Tamanho: ");
                        r.setTamanho(sc.nextLine());

                        System.out.print("Gênero: ");
                        r.setGenero(sc.nextLine());

                        System.out.print("Material: ");
                        r.setMaterial(sc.nextLine());

                        System.out.print("Lavável na máquina (true/false): ");
                        r.setLavavelNaMaquina(sc.nextBoolean());
                        sc.nextLine();

                        System.out.print("Quantidade: ");
                        r.setQuantidade(Integer.parseInt(sc.nextLine()));

                        System.out.print("Preço: ");
                        r.setPreco(Double.parseDouble(sc.nextLine().replace(",", ".")));

                        dao.inserir(r);
                        System.out.println("Roupa cadastrada!");
                        break;

                    case 2:
                        dao.listarTodos().forEach(System.out::println);
                        break;

                    case 3:
                        System.out.print("ID: ");
                        int idBuscar = Integer.parseInt(sc.nextLine());
                        Roupa rr = dao.buscarPorId(idBuscar);
                        System.out.println(rr != null ? rr : "Não encontrada.");
                        break;

                    case 4:
                        System.out.print("ID: ");
                        int idRemover = Integer.parseInt(sc.nextLine());
                        dao.remover(idRemover);
                        System.out.println("Removida.");
                        break;
                }

            } catch (SQLException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }

        } while (op != 0);
    }


    // ====================== MENU PERECÍVEL =======================

    public static void menuPerecivel(Scanner sc, PerecivelDAO dao) {
        int op;

        do {
            System.out.println("\n=== MENU PERECÍVEL ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Remover");
            System.out.println("0 - Voltar");

            op = Integer.parseInt(sc.nextLine());

            try {
                switch (op) {
                    case 1:
                        Perecivel p = new Perecivel();

                        System.out.print("Nome: ");
                        p.setNome(sc.nextLine());

                        System.out.print("Marca: ");
                        p.setMarca(sc.nextLine());

                        System.out.print("Categoria: ");
                        p.setCategoria(sc.nextLine());

                        System.out.print("Embalagem: ");
                        p.setEmbalagem(sc.nextLine());

                        System.out.print("Origem: ");
                        p.setOrigem(sc.nextLine());


                        try {
                            System.out.print("Data fabricação (2025-02-21): ");
                            p.setDtFabricacao(sc.nextLine());

                            System.out.print("Data validade (2025-02-21): ");
                            p.setDtValidade(sc.nextLine());

                        } catch (ExcecaoDataInvalida e) {
                            System.out.println("Erro: " + e.getMessage());
                            System.out.println("Voltando ao menu...");
                            return; // volta para o menu principal sem quebrar o programa
                        }


                        System.out.print("Quantidade: ");
                        p.setQuantidade(Integer.parseInt(sc.nextLine()));

                        System.out.print("Preço: ");
                        p.setPreco(Double.parseDouble(sc.nextLine().replace(",", ".")));

                        dao.inserir(p);
                        System.out.println("Perecível cadastrado!");
                        break;


                    case 2:
                        dao.listarTodos().forEach(System.out::println);
                        break;


                    case 3:
                        System.out.print("ID: ");
                        int idBuscar = Integer.parseInt(sc.nextLine());
                        Perecivel pp = dao.buscarPorId(idBuscar);
                        System.out.println(pp != null ? pp : "Não encontrado.");
                        break;


                    case 4:
                        System.out.print("ID: ");
                        int idRemover = Integer.parseInt(sc.nextLine());
                        dao.remover(idRemover);
                        System.out.println("Removido.");
                        break;
                }

            } catch (SQLException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }

        } while (op != 0);
    }


    // ====================== MENU FERRAMENTA ======================

    public static void menuFerramenta(Scanner sc, FerramentaDAO dao) {
        int op;

        do {
            System.out.println("\n=== MENU FERRAMENTA ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Remover");
            System.out.println("0 - Voltar");

            op = Integer.parseInt(sc.nextLine());

            try {
                switch (op) {
                    case 1:
                        Ferramenta f = new Ferramenta();

                        System.out.print("Nome: ");
                        f.setNome(sc.nextLine());

                        System.out.print("Marca: ");
                        f.setMarca(sc.nextLine());

                        System.out.print("Tipo: ");
                        f.setTipo(sc.nextLine());

                        System.out.print("É elétrica? (s/n): ");
                        String opcao = sc.nextLine().trim().toLowerCase();

                        if (opcao.equals("s")) {
                            f.setEletrica(true);

                            System.out.print("Potência (em watts): ");
                            f.setPotencia(Integer.parseInt(sc.nextLine()));

                        } else {
                            f.setEletrica(false);
                            f.setPotencia(0); // ← garante que não terá potência se não for elétrica
                        }

                        System.out.print("Categoria: ");
                        f.setCategoria(sc.nextLine());

                        System.out.print("Material: ");
                        f.setMaterial(sc.nextLine());

                        System.out.print("Peso: ");
                        f.setPeso(Double.parseDouble(sc.nextLine().replace(",", ".")));

                        System.out.print("Comprimento: ");
                        f.setComprimento(Double.parseDouble(sc.nextLine().replace(",", ".")));

                        System.out.print("Quantidade: ");
                        f.setQuantidade(Integer.parseInt(sc.nextLine()));

                        System.out.print("Preço: ");
                        f.setPreco(Double.parseDouble(sc.nextLine().replace(",", ".")));

                        dao.inserir(f);
                        System.out.println("Ferramenta cadastrada!");
                        break;


                    case 2:
                        dao.listarTodos().forEach(System.out::println);
                        break;


                    case 3:
                        System.out.print("ID: ");
                        int idBuscar = Integer.parseInt(sc.nextLine());
                        Ferramenta ff = dao.buscarPorId(idBuscar);
                        System.out.println(ff != null ? ff : "Não encontrada.");
                        break;


                    case 4:
                        System.out.print("ID: ");
                        int idRemover = Integer.parseInt(sc.nextLine());
                        dao.remover(idRemover);
                        System.out.println("Removida.");
                        break;
                }

            } catch (SQLException ex) {
                System.out.println("Erro: " + ex.getMessage());
            }

        } while (op != 0);
    }
}
