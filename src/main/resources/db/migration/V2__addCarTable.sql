CREATE TABLE car(
  id BIGSERIAL PRIMARY KEY,
  gosnumber VARCHAR NOT NULL,
  mark VARCHAR NOT NULL,
  model VARCHAR NOT NULL,
  owner_id BIGSERIAL,
  fine_id BIGSERIAL
)