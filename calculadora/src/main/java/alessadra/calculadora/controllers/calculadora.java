package alessadra.calculadora.controllers;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("calculadora")
public class calculadora {


    @GetMapping("somar")
    public int soma(@RequestParam  int numero1,@RequestParam int numero2){
        return numero1 + numero2;
    }

    @GetMapping("subtrair")
    public int subtracao(@RequestParam int numero1, @RequestParam  int numero2){
        return numero1 - numero2;
    }

    @GetMapping("calcular/{operacao}")
    public String calcular(@PathVariable String operacao,@RequestParam  int numero1, @RequestParam  int numero2,
                           @RequestParam(defaultValue = "2") int casasDecimais){


        switch (operacao){
            case "somar":
               return "Operação: " + operacao
                    + "<br>Número 1: " + numero1
                    + "<br>Número 2: " + numero2
                    + "<br>Resultado: " + (numero1+numero2);

            case "subtrair":  return "Operação: " + operacao
                    + "<br>Número 1: " + numero1
                    + "<br>Número 2: " + numero2
                    + "<br>Resultado: " + (numero1-numero2);


            case "multiplicar":
                return "Operação: " + operacao
                        + "<br>Número 1: " + numero1
                        + "<br>Número 2: " + numero2
                        + "<br>Resultado: " + (numero1*numero2);

            case "dividir":
                if(numero2 == 0){
                    return "Erro: não é possível dividir por zero";
                }
                double result = (double)numero1/numero2;

               return "Operação: " + operacao
                        + "<br>Número 1: " + numero1
                        + "<br>Número 2: " + numero2 + "\n"
                        + "<br>Resultado: " + String.format("%."+ casasDecimais+ "f", result);
            default:
                return "Erro: Operação inválida";

        }


    }

    @GetMapping("par-ou-impar/{numero}")
    public String parOuImpar(@PathVariable int numero){
        if(numero % 2 == 0){
            return "PAR";
        }
            return "IMPAR";

    }

   String tuEhOque(int numero){
        if(numero == 0){
            return "ZERO";
        }else if(numero > 0 ){
            return "POSITIVO";
        }
        return "NEGATIVO";
    }

    @GetMapping("analisar/{numero}")
    public String analisar(@PathVariable int numero){
        String resultParOuImpar = parOuImpar(numero);
        String resultTuEhOque = tuEhOque(numero);



        return "Numero: " + numero +
                "<br>Par ou Impar: "+resultParOuImpar
               + "<br>Positivo, negativo ou zero: "+ resultTuEhOque
               +  "<br>Dobro: " + numero * 2
               + "<br>Metade: "+ numero / 2.0
               +  "<br>Quadrado "+ Math.pow(numero,2);


    }




    @GetMapping("media")
    public String media(@RequestParam float nota1, @RequestParam float nota2, @RequestParam float nota3){

        float calcularMedia = (nota1 + nota2 + nota3)/3;
        String situacao;

        if(calcularMedia >= 7){
            situacao = "APROVADO";
        }else if(calcularMedia >= 4){
            situacao = "RECUPERAÇÃO";
        }else{
            situacao = "REPROVADO";
        }

        return "Média: "+ calcularMedia+
                "<br>Situação: "+situacao;

    }



}
