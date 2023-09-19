-- Kustutab public schema (mis põhimõtteliselt kustutab kõik tabelid)
DROP SCHEMA eat CASCADE;
-- Loob uue public schema vajalikud õigused
CREATE SCHEMA eat
-- taastab vajalikud andmebaasi õigused
    GRANT ALL ON SCHEMA eat TO postgres;
GRANT ALL ON SCHEMA eat TO PUBLIC;