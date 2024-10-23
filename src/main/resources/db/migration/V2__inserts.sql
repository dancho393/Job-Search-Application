INSERT INTO account_details (id, username, password, name, email, address, phone_number, city, account_type)
VALUES ('b3e56f5e-2a58-4a91-8194-ecc233cf4956', 'john_doe', '$2a$10$ro/mUzAnvooEAxwH9IBdXuibsQM94tV7auni4X4mULf9xCg8HoZeG', 'John Doe', 'john.doe@example.com', '123 Main St', '+1234567890', 'Leuven', 'USER'),
       ('b3e56f5e-2a58-4a91-8194-ecc233cf4957', 'KBC', '$2a$10$ro/mUzAnvooEAxwH9IBdXuibsQM94tV7auni4X4mULf9xCg8HoZeG', 'KBC GROUP', 'KBC@example.com', '123 Main St', '+1234567890', 'Leuven', 'COMPANY');
--this is the encrypted password

INSERT INTO companies (id, account_details_id, employee_count, rating)
VALUES (
           'b3e16e5e-9a58-4a91-8194-ecc233cf4956',
           'b3e56f5e-2a58-4a91-8194-ecc233cf4957',
           150,
           0.0
       );
INSERT INTO tech_stacks (id, name, description, image) VALUES
                                                           ('6eaf1b14-7f1d-468f-b236-1b246d7d7f35', 'Java', 'A high-level, class-based, object-oriented programming language widely used for building enterprise-level applications.', 'java.png'),
                                                           ('32b63b1d-5795-4cc6-9806-91a72f1cdbff', 'Spring Boot', 'A framework for building production-ready, stand-alone Java applications with minimal configuration.', 'spring_boot.png'),
                                                           ('779e674b-90d4-4a5a-bdd4-c8a1c036eb92', 'Python', 'A versatile and popular programming language known for its simplicity and wide range of applications in web development, data science, and more.', 'python.png'),
                                                           ('ebc07359-8b85-4fc7-9fa4-173f1dfdcb9c', 'Django', 'A high-level Python web framework that encourages rapid development and clean, pragmatic design.', 'django.png'),
                                                           ('59beae92-e8a7-4d7f-b2e9-91fbe8c1296f', 'JavaScript', 'A dynamic programming language that powers interactive behavior on websites and is a key technology of the web.', 'javascript.png'),
                                                           ('2fb77aa7-e179-4631-bc8b-e4543e4939af', 'React', 'A JavaScript library for building user interfaces, developed and maintained by Facebook.', 'react.png'),
                                                           ('86fe6f38-fffc-4661-b9f6-75f9e0c24f34', 'Node.js', 'A JavaScript runtime built on Chromes V8 engine, enabling server-side JavaScript execution.', 'nodejs.png'),
                                                           ('e2129b0e-017d-4d8d-9f93-2d6d5ebdc2f3', 'Express', 'A minimal and flexible Node.js web application framework that provides a robust set of features for web and mobile applications.', 'express.png'),
                                                           ('e96a8c83-d3a6-4d55-a0a9-c441029ab6c5', 'TypeScript', 'A strongly typed superset of JavaScript that compiles to plain JavaScript, providing better tooling and type safety.', 'typescript.png'),
                                                           ('13c63a2b-28b6-496b-bb4a-7a9cbbe1701d', 'Angular', 'A TypeScript-based framework for building dynamic web applications, developed and maintained by Google.', 'angular.png'),
                                                           ('c61aa63f-6a4d-41d4-96a1-c3a3c4f77e2b', 'C#', 'A modern, object-oriented programming language developed by Microsoft for building a wide range of applications, including desktop, web, and mobile.', 'csharp.png'),
                                                           ('bc76103e-d953-4f36-9171-0bfc01e09b7c', '.NET Core', 'A cross-platform framework for building modern, cloud-based, internet-connected applications.', 'dotnet_core.png'),
                                                           ('a05700e3-bb47-4238-91e2-16c4d803f89e', 'PHP', 'A popular general-purpose scripting language that is especially suited to web development.', 'php.png'),
                                                           ('31b3fa19-e8d0-4cf1-bc84-d29d5044df60', 'Laravel', 'A PHP web application framework with expressive, elegant syntax, designed for building web applications.', 'laravel.png'),
                                                           ('4b2058d9-b58e-4ec9-bc83-bd2a4589bb56', 'Ruby', 'A dynamic, open-source programming language with a focus on simplicity and productivity.', 'ruby.png'),
                                                           ('508dece5-6c2e-4734-825d-1a062065c2e5', 'Ruby on Rails', 'A server-side web application framework written in Ruby, designed to make programming web applications easier.', 'ruby_on_rails.png'),
                                                           ('9281a5fa-67c4-4746-bf94-449570c256db', 'Kotlin', 'A modern programming language targeting JVM and Android that is designed to be fully interoperable with Java.', 'kotlin.png'),
                                                           ('00475df6-84c0-43fd-a5f1-7fd5b1e21a92', 'Swift', 'A powerful and intuitive programming language for macOS, iOS, watchOS, and tvOS, developed by Apple.', 'swift.png'),
                                                           ('5d62565a-e98f-49d6-9142-b11a44b07ec7', 'Vue.js', 'A progressive JavaScript framework for building user interfaces, designed to be incrementally adoptable.', 'vuejs.png'),
                                                           ('6a7dba02-503b-45db-aaf8-faf49c52c222', 'Flutter', 'An open-source UI software development kit created by Google for building natively compiled applications for mobile, web, and desktop from a single codebase.', 'flutter.png');
