INSERT INTO customer (created_at, modified_at, "name")
    values(now(), now(), 'Deepak PS');


INSERT INTO product (created_at, modified_at, "name", description)
    values (now(), now(), 'Nail Cutter', 'Bell'),
           (now(), now(), 'Hair Dryer', 'Philips'),
           (now(), now(), 'Spike Buster', 'Anchor'),
           (now(), now(), 'Blender', 'Philips');
