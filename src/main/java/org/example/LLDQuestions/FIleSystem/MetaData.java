package org.example.LLDQuestions.FIleSystem;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class MetaData {
    int size;
    Date lastModified;
    Date createdOn;
}
