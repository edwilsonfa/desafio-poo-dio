import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso js");
        curso2.setDescricao("descrição curso js");
        curso2.setCargaHoraria(8);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("mentoria de java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());


        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developoer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        System.out.println(bootcamp.getNome());
        System.out.println("Cursos disponíveis:");
        bootcamp.getConteudos().forEach(System.out::println);

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcap(bootcamp);

        Dev devJoao = new Dev();
        devJoao.setNome("Joao");
        devJoao.inscreverBootcap(bootcamp);

        System.out.println("Devs incritos e progresso:");
        for(Dev dev : bootcamp.getDevsInscritos()){
            System.out.println("***" +dev.getNome()+ "***");
            System.out.println("Inscrito(a) em: "+dev.getConteudosInscritos());
            int q = dev.getConteudosInscritos().size();
            for(int i = 1; i <= q; i++){
                System.out.println("Concluindo: "+dev.getConteudosInscritos().stream().findFirst().get().getTitulo());
                dev.progredir();
            }
            System.out.println("Cusros Inscritos : "+dev.getConteudosInscritos());
            System.out.println("Cursos Concluidos : "+dev.getConteudosConcluidos());
        }
    }
}