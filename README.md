# spark2demo

para compilar:
En la terminal, En la raiz del proyecto usar >sbt package 

para ejecutar:
En la terminal, en la carpeta que contiene el jar generado anteriormente, usar >spark-submit --packages org.apache.hadoop:hadoop-aws:2.7.3 --class pocFis.GetAwsFileToAnalyzeExample2 spark2demo_2.12-0.1.jar

Nota: Se debe editar la ruta del bucket S3 y las credenciales de AWS

