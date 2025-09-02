package com.apigate.mcp.oas;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name = "apis")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Api {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "api_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    private String endpoint;

    private int level;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String specContent;

    @CreationTimestamp
    private LocalDateTime createdAt; // 생성 일시

    @UpdateTimestamp
    private LocalDateTime updatedAt; // 마지막 수정 일시

    public Api(String title, String description, int level, String endpoint) {
        this.title = title;
        this.description = description;
        this.level = level;
        this.endpoint = endpoint;
    }
}
