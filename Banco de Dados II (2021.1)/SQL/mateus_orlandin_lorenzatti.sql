# --------------------------------------------------------------------

# Mateus Orlandin Lorenzatti
# Lista de Exercícios 1

# --------------------------------------------------------------------

# 1.No schemadb_app_db2, interprete e implemente a estrutura abaixo com SQL

CREATE TABLE Autor ( 
	   ID_autor INT NOT NULL AUTO_INCREMENT
     , nome VARCHAR(255)
     , nascimento DATE
     , PRIMARY KEY (ID_autor)
);

CREATE TABLE Livro (
       ID_livro INT NOT NULL AUTO_INCREMENT
     , nome VARCHAR(255)
     , primeira_publicacao DATE
     , categoria VARCHAR(255)
     , classificacao FLOAT
     , ID_autor INT NOT NULL

     , PRIMARY KEY (ID_livro)
     , FOREIGN KEY (ID_autor) REFERENCES Autor(ID_autor)
);

CREATE TABLE Leitor (
       ID_leitor INT NOT NULL AUTO_INCREMENT
     , nome VARCHAR(255)
     , nascimento DATE
     , email VARCHAR(255)

     , PRIMARY KEY (ID_leitor)
);

CREATE TABLE Leitura (
       ID_leitor INT NOT NULL
     , ID_livro INT NOT NULL
     , inicio_leitura DATE
     , fim_leitura DATE

     , PRIMARY KEY (ID_leitor, ID_livro)
     , FOREIGN KEY (ID_leitor) REFERENCES Leitor(ID_leitor)
     , FOREIGN KEY (ID_livro) REFERENCES Livro(ID_livro)
);

# --------------------------------------------------------------------

# 2.Insira no mínimo 3 leitores.

INSERT INTO Leitor (
		nome
	  , nascimento
	  , email
)
VALUES( 'Dagny Bellew'
      , '1950-09-08'
	  , 'dbellew0@mashable.com'
);

INSERT INTO Leitor (
		nome
	  , nascimento
	  , email
)
VALUES( 'Nerissa Dudmarsh'
      , '1965-11-24'
	  , 'ndudmarsh2@nifty.com'
);

INSERT INTO Leitor (
		nome
	  , nascimento
	  , email
)
VALUES( 'Austine Prettyjohns'
      , '1999-04-14'
	  , 'aprettyjohns1o@cargocollective.com'
);

# SELECT * FROM Leitor;

# --------------------------------------------------------------------

# 3.Insira no mínimo 3 livros (Dica: atenção as necessidades das constraints 
#   que você deve ter criado da interpretação do UML).

# Inserir entes dos livros os seus autores

INSERT INTO Autor (
		nome
	  , nascimento
)
VALUES( 'Benjamin Graham'
      , '1894-05-09'
);

INSERT INTO Autor (
		nome
	  , nascimento
)
VALUES( 'George Orwell'
      , '1903-06-25'
);

INSERT INTO Autor (
		nome
	  , nascimento
)
VALUES( 'Joanne Rowling'
      , '1965-07-31'
);

# SELECT * FROM Autor;

INSERT INTO Livro (
		nome
	  , primeira_publicacao
	  , categoria
	  , classificacao
	  , ID_autor 
)
VALUES( 'Animais Fantásticos e Onde Habitam'
      , '2001-07-31'
      , 'Fantasia'
      , 9.5
      , 3
);

INSERT INTO Livro (
		nome
	  , primeira_publicacao
	  , categoria
	  , classificacao
	  , ID_autor 
)
VALUES( 'O Investidor Inteligente'
      , '1949-01-31'
      , 'Economia'
      , 9.4
      , 1
);

INSERT INTO Livro (
		nome
	  , primeira_publicacao
	  , categoria
	  , classificacao
	  , ID_autor 
)
VALUES( '1984'
      , '1955-04-02'
      , 'Distopia'
      , 8.9
      , 2
);

# SELECT * FROM Livro;

# --------------------------------------------------------------------

# 4.Insira o relacionamento dos leitores com os livros que possuem 
# (Dica: As classes UML podem não corresponder exatamente a implementação em banco).

INSERT INTO Leitura (
		ID_leitor
	  , ID_livro
	  , inicio_leitura 
	  , fim_leitura
)
VALUES( 1
      , 2
      , '2021-04-25'
      , NULL
);

INSERT INTO Leitura (
		ID_leitor
	  , ID_livro
	  , inicio_leitura 
	  , fim_leitura
)
VALUES( 2
      , 1
      , '2020-10-22'
      , '2020-12-05'
);

INSERT INTO Leitura (
		ID_leitor
	  , ID_livro
	  , inicio_leitura 
	  , fim_leitura
)
VALUES( 3
      , 3
      , '2020-11-14'
      , '2021-05-28'
);

# SELECT * FROM Leitura;

/* SELECT CONCAT( le.nome, ' iniciou a leitura do livro "',  
               li.nome, '" no dia ', l.inicio_leitura, ', obra essa escrita por ', au.nome)
FROM Leitura l 
	LEFT JOIN Leitor le ON le.ID_leitor = l.ID_leitor
	LEFT JOIN Livro li ON li.ID_livro = l.ID_livro 
	LEFT JOIN Autor au ON au.ID_autor = li.ID_autor;
*/

# --------------------------------------------------------------------

# 5.Rode o script sakila-schema.sql seguido do script sakila-data.sql, disponíveis na tarefa do Moodle.

/*
SELECT table_name, table_type, engine 
FROM information_schema.tables 
WHERE table_schema = 'sakila';
*/

# --------------------------------------------------------------------

# 6. Os scripts criaram um schema no seu banco de dados e popularam com dados de amostra. 
# Esse esquema é um cenário de um sistema de gerenciamento de locadora de filmes. 
# Use o schema sakila e descubra as respostas para as questões usando SQL

USE sakila;

# --------------------------------------------------------------------

# 7. Quais atores têm no primeiro nome a sequência de caracteres "lett"?

# Conhecendo a tabela
SELECT * 
FROM actor 
LIMIT 10; 

# Aplicando a consulta
SELECT * 
FROM actor
WHERE first_name LIKE '%lett%';

# --------------------------------------------------------------------

# 8.Quais filmes possuem trailers?

# Conhecendo a tabela
SELECT * 
FROM film 
LIMIT 10; 

# Aplicando a consulta
SELECT * 
FROM film
WHERE special_features LIKE '%Trailers%';

# --------------------------------------------------------------------

# 9.Quais os tipos de classificações indicativas (rating) existentes nos 
# cadastros de filmes?

SELECT DISTINCT rating 
FROM film;

# --------------------------------------------------------------------

# 10.Quais filmes possuem drama na descrição e classificação indicativa 
# (rating) contendo a sequência de caracteres PG?

SELECT * 
FROM film
WHERE description LIKE '%Drama%'
      AND rating LIKE 'PG';

# --------------------------------------------------------------------

# 11.Faça uma consulta com uma projeção mostrando o tamanho da descrição 
# de cada filme, seguido de todos os outros atributos da tabela de filmes, 
# ordenando de maneira decrescente, da maior descrição para a menor, 
# somente dos filmes cujo custo de reposição (replacement_cost) esteja entre 20 e 25.
     
SELECT LENGTH(description) as desc_size
     , film_id
     , title
     , description
     , release_year
     , language_id
     , original_language_id
     , rental_duration
     , rental_rate
     , `length`
     , replacement_cost
     , rating
     , special_features
     , last_update     

FROM film
WHERE replacement_cost BETWEEN 20 AND 25
ORDER BY desc_size DESC;

# --------------------------------------------------------------------

# 12.Faça uma consulta das cidades projetando todas as colunas mais uma, 
#  na qual caso o código do país do registro seja 15, mostre Brasil, caso 
#  seja 104, mostre Espanha, 49 mostre Itália, e para os outros casos mostre ‘NA’.

# Conhecendo a tabela
SELECT * 
FROM city 
LIMIT 10; 

# Aplicando a consulta
SELECT *
	 , CASE country_id 
	 	   WHEN 15 THEN 'Brasil' 
	  	   WHEN 104 THEN 'Espanha' 
           WHEN 49 THEN 'Itália'
           ELSE 'NA'
       END as country_desc
FROM city;

# --------------------------------------------------------------------

# 13.Encontre todos os autores cujo primeiro nome é palíndromo.

SELECT * 
FROM actor
WHERE first_name = REVERSE(first_name);

# --------------------------------------------------------------------

# 14.Encontre todos os clientes (customer) cujo primeiro nome tem o mesmo 
# número de letras que o segundo, ou que o e-mail tem um a antes da letra
# anterior ao @.

# Conhecendo a tabela
SELECT * 
FROM customer 
LIMIT 10;

# Aplicando a consulta
SELECT * 
FROM customer
WHERE LENGTH(first_name) = LENGTH(last_name)
      OR email LIKE '%a_@%';
 
# --------------------------------------------------------------------
     
    



