package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
	public class Crypto {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		@Column(nullable = false)
		private String name;
		
		@Column(nullable = false)
		private String abbreviation;
		
		@Column(nullable = false)
		private Double amountCryp;
		
		@Column(nullable = false)
		private Double cost;

		public Crypto() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Crypto(Integer id, String name, String abbreviation, Double amountCryp, Double cost) {
			super();
			this.id = id;
			this.name = name;
			this.abbreviation = abbreviation;
			this.amountCryp = amountCryp;
			this.cost = cost;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getAbbreviation() {
			return abbreviation;
		}

		public void setAbbreviation(String abbreviation) {
			this.abbreviation = abbreviation;
		}

		public Double getAmountCryp() {
			return amountCryp;
		}

		public void setAmountCryp(Double amountCryp) {
			this.amountCryp = amountCryp;
		}

		public Double getCost() {
			return cost;
		}

		public void setCost(Double cost) {
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Crypto [id=" + id + ", name=" + name + ", abbreviation=" + abbreviation + ", amountCryp="
					+ amountCryp + ", cost=" + cost + "]";
		}
		
		
	}
