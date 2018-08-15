package com.example.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: baibing.shang
 * \* Date: 2018/8/15
 * \* Description:
 * \
 */
@Entity
@Table(name = "applicationlog")
@Data
public class ApplicationlogBean {

    @Id
    private String txid;
    @Column(columnDefinition = "text")
    private String data;
}