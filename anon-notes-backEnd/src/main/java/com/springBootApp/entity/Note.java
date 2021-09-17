package com.springBootApp.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;

import lombok.Data;

@Entity
@Table(name="tbl_notes")
@SQLDelete(sql = "DELETE FROM tbl_notes WHERE created_at<=DATE_SUB(NOW(), INTERVAL 1 DAY)")
@Data
public class Note {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	
	private String body;
	
	private String category;
	
	@Column(name="created_at", nullable=false, updatable = false)
	@CreationTimestamp
	private Date createdAt;
}
