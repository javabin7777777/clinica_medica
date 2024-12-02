// script para criar esta tabela com seus campos no bd clinica_medica.
//	esta tabela será preenchida com os dados da entidade(Entity) MedicoDB.
	
create table medicos (
	i d  b i g i n t  n o t  n u l l  a u t o _ i n c r e m e n t ,
	n o m e  v a r c h a r ( 1 0 0 )  n o t  n u l l ,
	e m a i l  v a r c h a r ( 1 0 0 )  n o t  n u l l  u n i q u e ,
	c r m  v a r c h a r ( 6 ) n o t  n u l l  u n i q u e ,
	e s p e c i a l i d a d e  v a r c h a r ( 1 0 0 )  n o t  n u l l ,
 	l o g r a d o u r o  v a r c h a r ( 1 0 0 )  n o t  n u l l ,
	b a i r r o  v a r c h a r ( 1 0 0 )  n o t  n u l l ,
	c e p  v a r c h a r ( 9 )  n o t n u l l ,	
	c i d a d e  v a r c h a r ( 1 0 0 )  n o t  n u l l ,
	u f  c h a r ( 2 )  n o t  n u l l ,
	n u m e r o  v a r c h a r ( 2 0 ) ,
	c o m p l e m e n t o  v a r c h a r ( 1 0 0 ) ,	
	
	p r i m a r y  k e y ( i d )
);