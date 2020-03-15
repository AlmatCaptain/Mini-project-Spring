--
-- PostgreSQL database dump
--

-- Dumped from database version 12.1
-- Dumped by pg_dump version 12.1

-- Started on 2020-03-15 12:52:23

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 203 (class 1259 OID 32851)
-- Name: employee; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employee (
    id bigint NOT NULL,
    name character varying(150) NOT NULL,
    password character varying(50) NOT NULL
);


ALTER TABLE public.employee OWNER TO postgres;

--
-- TOC entry 202 (class 1259 OID 32849)
-- Name: Employee_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public."Employee_id_seq"
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public."Employee_id_seq" OWNER TO postgres;

--
-- TOC entry 2835 (class 0 OID 0)
-- Dependencies: 202
-- Name: Employee_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public."Employee_id_seq" OWNED BY public.employee.id;


--
-- TOC entry 205 (class 1259 OID 32862)
-- Name: reservedrooms; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reservedrooms (
    employeeid integer NOT NULL,
    roomnumber character varying(10) NOT NULL,
    date timestamp without time zone NOT NULL,
    todate timestamp without time zone NOT NULL
);


ALTER TABLE public.reservedrooms OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 32857)
-- Name: room; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.room (
    number character varying(10) NOT NULL
);


ALTER TABLE public.room OWNER TO postgres;

--
-- TOC entry 2695 (class 2604 OID 32854)
-- Name: employee id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee ALTER COLUMN id SET DEFAULT nextval('public."Employee_id_seq"'::regclass);


--
-- TOC entry 2827 (class 0 OID 32851)
-- Dependencies: 203
-- Data for Name: employee; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.employee VALUES (123, 'Almat', 'almat');


--
-- TOC entry 2829 (class 0 OID 32862)
-- Dependencies: 205
-- Data for Name: reservedrooms; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2828 (class 0 OID 32857)
-- Dependencies: 204
-- Data for Name: room; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.room VALUES ('101');
INSERT INTO public.room VALUES ('102');
INSERT INTO public.room VALUES ('105');
INSERT INTO public.room VALUES ('301b');
INSERT INTO public.room VALUES ('404a');


--
-- TOC entry 2836 (class 0 OID 0)
-- Dependencies: 202
-- Name: Employee_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public."Employee_id_seq"', 1, false);


--
-- TOC entry 2697 (class 2606 OID 32856)
-- Name: employee Employee_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employee
    ADD CONSTRAINT "Employee_pkey" PRIMARY KEY (id);


--
-- TOC entry 2699 (class 2606 OID 32861)
-- Name: room Room_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.room
    ADD CONSTRAINT "Room_pkey" PRIMARY KEY (number);


-- Completed on 2020-03-15 12:52:24

--
-- PostgreSQL database dump complete
--

