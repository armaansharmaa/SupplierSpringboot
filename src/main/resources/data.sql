-- Create the supplier table
CREATE TABLE IF NOT EXISTS supplier (
    supplier_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    company_name VARCHAR(255) NOT NULL,
    website VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    nature_of_business VARCHAR(255) NOT NULL,
    manufacturing_processes VARCHAR(255) NOT NULL
);

-- Insert sample data into the supplier table
INSERT INTO supplier (supplier_id, company_name, website, location, nature_of_business, manufacturing_processes) VALUES
('1', 'Company A', 'http://companya.com', 'India', 'small_scale', '3d_printing'),
('2', 'Company B', 'http://companyb.com', 'USA', 'medium_scale', 'injection_molding'),
('3', 'Company C', 'http://companyc.com', 'UK', 'large_scale', 'machining'),
('4', 'Company D', 'http://companyd.com', 'Germany', 'small_scale', '3d_printing'),
('5', 'Company E', 'http://companye.com', 'France', 'medium_scale', 'injection_molding'),
('6', 'Company F', 'http://companyf.com', 'Italy', 'large_scale', 'machining');
