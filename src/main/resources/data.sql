-- Insert sample products if they don't exist
INSERT INTO products (name, description, price, stock_quantity, created_at, updated_at, is_active)
SELECT 'Smartphone', 'Latest model with high-end features', 999.99, 50, NOW(), NOW(), true
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Smartphone');

INSERT INTO products (name, description, price, stock_quantity, created_at, updated_at, is_active)
SELECT 'Laptop', 'Powerful laptop for developers', 1299.99, 30, NOW(), NOW(), true
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Laptop');

INSERT INTO products (name, description, price, stock_quantity, created_at, updated_at, is_active)
SELECT 'Headphones', 'Noise-cancelling wireless headphones', 249.99, 100, NOW(), NOW(), true
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Headphones');

INSERT INTO products (name, description, price, stock_quantity, created_at, updated_at, is_active)
SELECT 'Tablet', 'Lightweight tablet for productivity', 499.99, 45, NOW(), NOW(), true
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Tablet');

INSERT INTO products (name, description, price, stock_quantity, created_at, updated_at, is_active)
SELECT 'Smartwatch', 'Fitness tracking and notifications', 299.99, 60, NOW(), NOW(), true
WHERE NOT EXISTS (SELECT 1 FROM products WHERE name = 'Smartwatch');
