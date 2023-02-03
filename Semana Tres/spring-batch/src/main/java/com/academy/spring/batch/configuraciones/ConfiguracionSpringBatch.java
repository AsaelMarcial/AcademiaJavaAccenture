package com.academy.spring.batch.configuraciones;

import com.academy.spring.batch.entidades.Cliente;
import com.academy.spring.batch.repositorio.RepositorioClientes;

import lombok.AllArgsConstructor;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class ConfiguracionSpringBatch {

    private JobBuilderFactory jobBuilderFactory;
    private StepBuilderFactory stepBuilderFactory;
    private RepositorioClientes repositorioClientes;

	@Bean
    public FlatFileItemReader<Cliente> lector() {
        FlatFileItemReader<Cliente> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource("src/main/resources/clientes.csv"));
        itemReader.setName("csvReader");
        itemReader.setLinesToSkip(1);
        itemReader.setLineMapper(mapearFilas());
        return itemReader;
    }

    private LineMapper<Cliente> mapearFilas() {
        DefaultLineMapper<Cliente> lineMapper = new DefaultLineMapper<>();

        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id", "nombre", "apellidos", "email", "genero", "telefono", "pais", "fecha");

        BeanWrapperFieldSetMapper<Cliente> mapeadorDatos = new BeanWrapperFieldSetMapper<>();
        mapeadorDatos.setTargetType(Cliente.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(mapeadorDatos);
        return lineMapper;

    }

    @Bean
    public ProcesadorClientes procesador() {
        return new ProcesadorClientes();
    }

    @Bean
    public RepositoryItemWriter<Cliente> escritor() {
        RepositoryItemWriter<Cliente> writer = new RepositoryItemWriter<>();
        writer.setRepository(repositorioClientes);
        writer.setMethodName("save");
        return writer;
    }

    @Bean
    public Step paso1() {
        return stepBuilderFactory.get("csv-step").<Cliente, Cliente>chunk(10)
                .reader(lector())
                .processor(procesador())
                .writer(escritor())
                .taskExecutor(ejecutarTarea())
                .build();
    }

    @Bean
    public Job runJob() {
        return jobBuilderFactory.get("importCustomers")
                .flow(paso1()).end().build();

    }

    @Bean
    public TaskExecutor ejecutarTarea() {
        SimpleAsyncTaskExecutor asyncTaskExecutor = new SimpleAsyncTaskExecutor();
        asyncTaskExecutor.setConcurrencyLimit(10);
        return asyncTaskExecutor;
    }

}
