//package spring.academy.course.billingjob;
//
//import org.springframework.batch.core.*;
//import org.springframework.batch.core.repository.JobRepository;
//
//// Spring Batch provides ready-to-use Job implementations like
//// SimpleJob for simple sequential step-based jobs and
//// FlowJob for jobs which requires a complex step execution flows.
//public class BillingJob implements Job {
//
//    private JobRepository jobRepository;
//
//    public BillingJob(JobRepository jobRepository) {
//        this.jobRepository = jobRepository;
//    }
//
//    @Override
//    public String getName() {
//        return "BillingJob";
//    }
//
//    @Override
//    public void execute(JobExecution execution) {
//        JobParameters jobParameters = execution.getJobParameters();
//        String inputFile = jobParameters.getString("input.file");
//        System.out.println("processing billing information from file " + inputFile);
//        execution.setStatus(BatchStatus.COMPLETED);
//        execution.setExitStatus(ExitStatus.COMPLETED);
//        this.jobRepository.update(execution);
//    }
//}
