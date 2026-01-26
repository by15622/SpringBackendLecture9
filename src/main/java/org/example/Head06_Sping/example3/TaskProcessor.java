package org.example.Head06_Sping.example3;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
@Scope("prototype")  // 요청할 때마다 새 인스턴스 생성
public class TaskProcessor {

    // 프로토타입에서는 상태를 가져도 안전합니다 (각각 다른 인스턴스이므로)
    private String taskId = UUID.randomUUID().toString();
    private LocalDateTime createdAt = LocalDateTime.now();
    private TaskStatus status = TaskStatus.CREATED;

    public void processTask(String data) {
        this.status = TaskStatus.PROCESSING;
        // 복잡한 작업 처리...
        System.out.println("처리 중인 Task ID: " + taskId);
        this.status = TaskStatus.COMPLETED;
    }

    // 각 인스턴스마다 다른 값을 가집니다
    public String getTaskId() {
        return taskId;
    }
}