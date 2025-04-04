package com.example.rhealth_hms.data.models;

import com.example.rhealth_hms.data.models.enums.TestRequestsStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "test_requests")
public class TestRequest extends IdEntity {

    @ManyToOne(optional = false)
    private Test test;

    @ManyToOne(optional = false)
    private Session session;

    @ManyToOne(optional = false)
    private User staff;

    @ManyToOne(optional = false)
    private Patient patient;

    @Column(nullable = false)
    private String note;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TestRequestsStatus status;
}
