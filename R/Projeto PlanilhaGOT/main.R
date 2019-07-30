  ------------------
    # Projeto II feito por:
    # Antonio Barros da Silva Netto (absn2)
    # Lucas Emanuel de Farias Mendes (lefm)
    # Lucas Rodrigues dos Santos Valenca (lrsv)
    
    
    # Questao 1:    
    
    # atribuiu a variavel got, a leitura de um planilha.
    got = read.csv("PlanilhaGOT.csv", header = TRUE)
    # comando para imprimir o dataframe atribuido a variavel.
    print(got)
  
    # Questao 2:
  
    got = read.csv("PlanilhaGOT.csv", header = TRUE)
    # atribui-se a vaiiavel notas, o vector de t?tulo Nota, onde #vai esta alocado as notas de cada episodio da serie
    notas = got$Nota
    # usamos 2 funcoes da biblioteca do Rstudio para calcular a #media e o desvio padrao respectivamente.
    media = mean(notas)
    desvioPadrao = sd(notas)
    # usamos notas na funcao table, para retornar uma tabela onde 
    # aparece a quantidade de vezes que aparecem cada nota 
    # atribuida a um episodio. Continuando, se utilizou o which.max 
    # e names, para retornar apenas o nome do valor que se repete 
    # mais vezes, e as.numeric para transform de "string" para "int".
    mode = as.numeric(names(which.max(table(notas))))
    print(media)
    print(mode)
    print(desvioPadrao)
    
    # Questao 3:
  
    got = read.csv("PlanilhaGOT.csv", header = TRUE)
     # atribui-se a variavel notas, o vector de titulo "Audiencia.Em.milhoes", onde vai esta alocado a audencia de 
     # cada episodio da serie.
     audiencia = got$Audiencia.Em.milhoes.
     # E utilizando a biblioteca do Rstudio achamos a 
     # media,desvioPadrao e mediana.
     media = mean(audiencia)
     desvioPadrao = sd(audiencia)
     mediana = median(audiencia)
     print(media)
     print(desvioPadrao)
     print(mediana)
  
  
   # Questao 4:
     
    episodios = function(x) {
    # variavel index, indica o valor da posicao do vetor.
    index = 1
    eps = NULL
    for (i in x$Nota) {
      # se i >= 9.00, quer dizer que ele passa nas especificacoes da #pergunta.
      if (i >= 9.00) {
        # x[index,2] nos retorna o nome do episodio, ai transformamos em "string" com o comando as.character.
        nome = as.character(x[index,2])  
        # Armazenamos na variavel eps, um novo vetor que vai conter o #vetor anterior, mais o nome do episodio, formando o vetor dos #episodios.  
        eps = c(eps, nome)
        
      }
      index = index + 1
    }
    # retorna o vetor resultante
    return (eps)
  }
    got = read.csv("PlanilhaGOT.csv", header = TRUE)
    # chamamos a funcao episodios, que vai retornar os episodios da #serie dada as especifica??es da funcao
    eps = episodios(got)
    print (eps)
  
    # Questao 5:
    
    got = read.csv("PlanilhaGOT.csv", header = TRUE)
    # essa funcao chamada para cada temporada, e nela, achamos o ep com menor
    # e maior nota de cada temporada
    notaseps = function(x, temporada, ep1, epFinal, qtdEps1, qtdEps7) {
      
      epmaiornota = 1
      epmenornota = 1
      nomeepmaior = "nome"
      nomeepmenor = "nome"
      temp = temporada
      
      for (j in ep1:epFinal) {
        
        # caso seja o primeiro ep ta temporada, ele atribui a nota e o nome
        # do ep as variaveis criadas acima
        
        if (j == 1 || j == qtdEps1+1 || j == (qtdEps1*2)+1 || j == (qtdEps1*3)+1 
            || j == (qtdEps1*4)+1 || j == (qtdEps1*5)+1 || j == (qtdEps1*6)+1 || (qtdEps1*6)+1+qtdEps7) {
          epmaiornota = as.character(x[j, 3])
          epmenornota = as.character(x[j, 3])
          nomeepmaior = as.character(x[j, 2])
          nomeepmenor = as.character(x[j, 2])
          
        } else {
          # aqui, comparamos a nota atual com a passada e verificamos se
          # e menor ou maior
          if (x[j, 3] >= epmaiornota) {
            epmaiornota = as.character(x[j, 3])
            nomeepmaior = as.character(x[j, 2])
            
          } else if (x[j, 3] <= epmenornota) {
            epmenornota = as.character(x[j, 3])
            nomeepmenor = as.character(x[j, 2])
            
          }
        }
      }
      
      episodios = c(nomeepmenor, nomeepmaior)
      return (episodios)
    }
    
    #verifica quantas temps existem
    qtdTemps = got[length(got[,1]), 1]
    temps = c()
    for (i in 1:qtdTemps) {
      temps = c(temps, i)
    }
    
    qtdEps1 = 0;  
    qtdEps2 = 0;  
    qtdEps3 = 0; 
    qtdEps4 = 0; 
    qtdEps5 = 0; 
    qtdEps6 = 0; 
    qtdEps7 = 0; 
    qtdEps8 = 0;
    
    #verifica quantos eps tem em cada temporada
    for (i in 1:length(got[,1])) {
      if (got[i,1] == 1) {
        qtdEps1 = qtdEps1+1
      } else if (got[i,1] == 2) {
        qtdEps2 = qtdEps2+1
          
      } else if (got[i,1] == 3) {
         qtdEps3 = qtdEps3+1
          
       } else if (got[i,1] == 4) {
         qtdEps4 = qtdEps4+1
           
       } else if (got[i,1] == 5) {
         qtdEps5 = qtdEps5+1
           
       } else if (got[i,1] == 6){
         qtdEps6 = qtdEps6+1
           
       } else if (got[i,1] == 7) {
         qtdEps7 = qtdEps7+1
           
       } else if (got[i,1] == 8) {
         qtdEps8 = qtdEps8 + 1
       }
    }

    #chamamos a funcao para cada temporada
    eps1 = notaseps(got, temps[1], 1, qtdEps1, qtdEps1, qtdEps7)
    eps2 = notaseps(got, temps[2], 1+(qtdEps1), qtdEps1*2, qtdEps1, qtdEps7)
    eps3 = notaseps(got, temps[3], 1+(qtdEps1*2), qtdEps1*3, qtdEps1, qtdEps7)
    # <3
    eps4 = notaseps(got, temps[4], 1+(qtdEps1*3), qtdEps1*4, qtdEps1, qtdEps7)
    #essa temporada eh mt ruim
    eps5 = notaseps(got, temps[5], 1+(qtdEps1*4), qtdEps1*5, qtdEps1, qtdEps7)
    eps6 = notaseps(got, temps[6], 1+(qtdEps1*5), qtdEps1*6, qtdEps1, qtdEps7)
    #essas duas tb
    eps7 = notaseps(got, temps[7], 1+(qtdEps1*6), (qtdEps1*6)+qtdEps7, qtdEps1, qtdEps7)
    eps8 = notaseps(got, temps[8], 1+(qtdEps1*6)+qtdEps7, length(got[,1]), qtdEps1, qtdEps7)
    todoseps = c(eps1, eps2, eps3, eps4, eps5, eps6, eps7, eps8)
    
    x = got
    #usamos o match para pegar o indice da linha do episodio com menor e
    #maior nota, e entaoo adicionamos a nota do epis?dio no vetor
    notas = c(x[match(eps1[1], got[,2]), 3], x[match(eps1[2], got[,2]), 3], x[match(eps2[1], got[,2]), 3], x[match(eps2[2], got[,2]), 3], x[match(eps3[1], got[,2]), 3], x[match(eps3[2], got[,2]), 3], x[match(eps4[1], got[,2]), 3], x[match(eps4[2], got[,2]), 3],
              x[match(eps5[1], got[,2]), 3], x[match(eps5[2], got[,2]), 3], x[match(eps6[1], got[,2]), 3], x[match(eps6[2], got[,2]), 3], x[match(eps7[1], got[,2]), 3], x[match(eps7[2], got[,2]), 3], x[match(eps8[1], got[,2]), 3], x[match(eps8[2], got[,2]), 3])
   
    #criamos um vetor com a temporada de cada ep
    temporadas = c()
    for (i in 1:length(todoseps)) {
      temporadas = c(temporadas, got[match(todoseps[i], got[,2]), 1])
    }
    
    #criamos o dataframe com as colunas Titulo, Nota e Temporada, e inserimos
    #os episodios de cada temporadas, as notas e as temporadas ordenadas
    notasfinal = data.frame(Titulo = c(todoseps), 
                            Nota = c(notas),
                            Temporada = c(temporadas),
                            stringsAsFactors = FALSE)
    print (todoseps)
    print (notasfinal)
    
  # Questao 6:
  
  # funcao feita para calcular o numero total de temporadas, como esta ordenado crescentemente
  # o ultimo numero que a variavel lastNumb armazenar vai ser necessariamente o ultimo numero indicando a temporada.
  numbSeason = function (x) {
    lastNumb = 1
    for (i in x) {
      if (i > lastNumb) {
        lastNumb = i
      }
    }
    return (lastNumb)
  }
  # funcao feita para retornar a temporada de menor desvioPadrao.
  minorSort = function (x) {
    numbSeason = numbSeason(x$Temporada)
    compareSD = NULL
    i = 1
    # variavel "i", indica a temporada no qual ele vai calcular o desvioPadrao, e o i tem que ir a ultima temporada.
    while (i <= numbSeason) {
      index = 1
      auxSd = NULL
      for (y in x$Audiencia.Em.milhoes.) {
        # se a temporada que achamamos percorrendo o FOR, for igual ao "i", entao adiciomamos
        # a audencia daquele index.
        if (x[index, 1] == i) {
          auxSd = c(auxSd, y)
        }
        index = index + 1
      }
      i = i + 1
      # vetor auxSd representa um vetor com todas as audencias daquela temporada, logo usamos a funcao do R
      # para calcular o desvioPadrao daquela temporada e adicionamos logo em seguida, em um vetor chamado
      # "compareSD" que vai conter cada desvioPadrao de cada temporada.
      auxSd = sd(auxSd)
      compareSD = c(compareSD, auxSd)
    }
    menor = NULL
    index = 1
    temp = 1
    # em seguida vamos ver qual o menor desvioPadrao do vetor "CompareSD".
    for (i in compareSD) {
      # na primeira chamada do FOR, precisamos adicionar o primeiro elemento a variavel menor, e tambem adicionamos
      # a variavel temp, o index(representa a temporada).
      if (is.null(menor)) {
        menor = i
        temp = index
      } else {
        if (i < menor) {
          menor = i
          temp = index
        }
      }
      # como compareSD, esta implicitamente ordenado pelo numero de temporadas, quer dizer que as posicoes [1...8]
      # representam exatamente as temporadas 1 ate 8, do data frame original "got", logo toda vez que aumentamos
      # o index em +1, logo estamos representando entrelinhas a temporada de valor, "index".
      index = index + 1
    }
    return (temp)
  }
  got = read.csv("PlanilhaGOT.csv", header = TRUE)
  temp = minorSort(got)
  print (temp)

  # Questao 7:
  
  mediaPersonagem = function(x, nome) {
    # variavel index, indica a posicao do vetor.
    index = 1
    notas = NULL
    for (i in x$Nota) {
      aparece = FALSE
      personagens = as.character(x[index, 4])
      # damos um split no texto dos personagens pra criar um vetor.
      personagens = unlist(strsplit(as.character(personagens), ","))
      # percorremos o vetor para saber se algum indice dele contem "nome".
      for (j in personagens){
        if (j == nome){
          aparece = TRUE
          break
        }
      }
      # se contem "nome" quer dizer que ele passa nas especificacoes da #pergunta.
      if (aparece) {
        # armazenamos as notas em um novo vetor e cauculamos a media.
        nota = (i)
        notas = c(notas, nota)
      }
      index = index + 1
    }
    # retorna a media do vetor das notas
    return (mean(notas))
  }
  
  got = read.csv("PlanilhaGOT.csv", header = TRUE)
  media = mediaPersonagem(got, 'Brienne of Tarth(Gwendoline Christie)')
  print(media)
  
  # Questao 8:
  
  perso = function (x) {
   index = 1
   per = NULL
   for (i in x$Personagens) {
     # procuramos quando for apenas a 4 temporada
     if (x[index, 1] == 4) {
       personagens = as.character(x[index, 4])
       # como sao varios personagens em um texto, damos split toda vez que achar uma virgula
       # e em seguida adicionamos todos os personagens em um novo array de personagens.
       personagens = unlist(strsplit(as.character(personagens), ","))
       per = c(per, personagens)
     }
      index = index + 1
   }
    # transformar o array per em uma tabela de frequencias
    table = table(per)
    # e da tabela nos transformamos ela um dataframe, que agora vai ter 2 colunas
    # uma chamada per, que contem o nome dos personagens e outra chama Freq, com suas frequencias de aparicoes.
    frequency=as.data.frame(table)
    names = NULL
    index = 1
    for (i in frequency[,2]) {
      if (i == 1) {
        # vamos procurar apenas as que a frequencia seja igual a 1 ou seja apareceu em apenas um episodio
        # depois de encontrada colocamos no nosso array de personagens.
        character = as.character(frequency[index,1])
        names = c(names, character)
      }
      index = index+1
    }
    return (names)
  }
  
  got = read.csv("PlanilhaGOT.csv", header = TRUE)
  names = perso(got)
  print(names)
 
  # Questao 9:
  
  # funcao feita para calcular numero maximo de temporadas.
  numbSeason = function (x) {
    lastNumb = 1
    for (i in x[,1]) {
      if (i > lastNumb) {
        lastNumb = i
      }
    }
    return (lastNumb)
  }
  
  #funcao feita para calcular a quantidade de vezes que eles aparecem na serie
  search = function(x,y) {
    numbSeason = numbSeason(x)
    i = 1
    freq = NULL
    while (i <= numbSeason) {
      index = 1
      for (z in x[,4]) {
        if (i == x[index,1]) {
          # essa funcao grepl retorna se existe alguma substring de 
          # z(string de nome de todos os personagens de um episodio), que vai ser igual
          # ao valor de y (nome do personagem).
          if (grepl(y,z)) {
            # se for igual, entao num vetor de freq, adiciono nele qual temporada daquele episodio
            # ele aparece, logo formando um grande vetor de episodios.
            freq = c(freq,i)
          }
        }
        index = index + 1
      }
      i = i + 1
    }
    return (freq)
  }
  
  got = read.csv("PlanilhaGOT.csv", header = TRUE)
  # atribua a variavel personagem o nome do personagem que voce quer colocar
  # no exemplo de baixo colocamos "Bran Stark"
  personagem = "Bran Stark"
  freq = search(got,personagem)
  #vai imprimir um histograma feito pela as especificacoes abaixo.
  hist(freq, main = personagem, col = "pink", border = "darkblue", xlab = "Temporada", 
       ylab = "Ocorrencia", breaks = c(0,1,2,3,4,5,6,7,8))
  
  
  