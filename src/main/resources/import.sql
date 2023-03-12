INSERT INTO public.role(name) VALUES ('ROLE_ADMINISTRADOR');
INSERT INTO public.role(name) VALUES ('ROLE_GERENTE');
INSERT INTO public.role(name) VALUES ('ROLE_COLABORADOR');

INSERT INTO public.usuario(email, senha) VALUES ('ghisi@ghisi.com', '$2a$10$RBRAY80jWJFbGYVZ9qxcLOuQHyg.2kBNMFKOJdGm/XNn8UpHcgV7i');
INSERT INTO public.usuario(email, senha) VALUES ('ghisi1@ghisi1.com', '$2a$10$RBRAY80jWJFbGYVZ9qxcLOuQHyg.2kBNMFKOJdGm/XNn8UpHcgV7i');
INSERT INTO public.usuario(email, senha) VALUES ('ghisi2@ghisi2.com', '$2a$10$RBRAY80jWJFbGYVZ9qxcLOuQHyg.2kBNMFKOJdGm/XNn8UpHcgV7i');

INSERT INTO public.usuarios_role(usuario_id, role_id) VALUES (1, 1);
INSERT INTO public.usuarios_role(usuario_id, role_id) VALUES (2, 2);
INSERT INTO public.usuarios_role(usuario_id, role_id) VALUES (3, 3);

INSERT INTO public.medicamentos(nome_medicamento, nome_laboratorio, dosagem_medicamento, descricao_medicamento,preco_unitario, tipo_medicamento) VALUES ('testeMedicamento', 'testeMedicamento', 'testeMedicamento', 'testeMedicamento', 45, 'testeMedicamento');
