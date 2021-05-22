DROP TABLE IF EXISTS contracts CASCADE;
DROP TABLE IF EXISTS farms CASCADE;
DROP TABLE IF EXISTS production_cycles CASCADE;
DROP TABLE IF EXISTS farm_with_production_cycle CASCADE;

CREATE TABLE IF NOT EXISTS contracts
(
    id                              SERIAL PRIMARY KEY,
    contract_duration_in_years      BIGINT NOT NULL,
    number_of_young_animals_sold    BIGINT NOT NULL,
    number_of_adult_animals_sold    BIGINT NOT NULL,
    number_of_old_animals_sold      BIGINT NOT NULL,
    young_animal_selling_cost       BIGINT NOT NULL,
    adult_animal_selling_cost       BIGINT NOT NULL,
    old_animal_selling_cost         BIGINT NOT NULL,
    cost_of_feed_needs_to_purchased BIGINT NOT NULL,
    unsold_animal_forfeit           BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS farms
(
    id                      SERIAL PRIMARY KEY,
    animal_type             VARCHAR(40)  NOT NULL,
    farm_owner              VARCHAR(120) NOT NULL,
    capital                 BIGINT       NOT NULL,
    is_bankrupt             BOOLEAN DEFAULT FALSE,
    number_of_young_animals BIGINT       NOT NULL,
    number_of_adult_animals BIGINT       NOT NULL,
    number_of_old_animals   BIGINT       NOT NULL,
    contract_id             BIGINT,

    CONSTRAINT contract_id_fk FOREIGN KEY (contract_id) REFERENCES contracts (id)
);

CREATE TABLE IF NOT EXISTS production_cycles
(
    id                                           SERIAL PRIMARY KEY,
    year_number                                  BIGINT NOT NULL,

    adult_animal_fertility_rate                  BIGINT NOT NULL,
    old_animal_fertility_rate                    BIGINT NOT NULL,

    young_animal_survival_rate                   BIGINT NOT NULL,
    old_animal_mortality_rate                    BIGINT NOT NULL,

    number_of_young_animals_at_the_start_of_year BIGINT NOT NULL,
    number_of_adult_animals_at_the_start_of_year BIGINT NOT NULL,
    number_of_old_animals_at_the_start_of_year   BIGINT NOT NULL,

    number_of_young_animals_at_the_end_of_year   BIGINT NOT NULL,
    number_of_adult_animals_at_the_end_of_year   BIGINT NOT NULL,
    number_of_old_animals_at_the_end_of_year     BIGINT NOT NULL,

    feed_cost_for_one_animal                     BIGINT NOT NULL,
    total_feed_cost                              BIGINT NOT NULL,

    number_of_born_animals                       BIGINT NOT NULL,
    number_of_sold_animals                       BIGINT NOT NULL,

    total_year_income                            BIGINT NOT NULL,
    total_year_expenses                          BIGINT NOT NULL,

    farm_capital                                 BIGINT NOT NULL
);

CREATE TABLE IF NOT EXISTS farm_with_production_cycle
(
    farm_id             BIGINT,
    production_cycle_id BIGINT,

    CONSTRAINT farm_id_fk FOREIGN KEY (farm_id) REFERENCES farms (id),
    CONSTRAINT production_cycle_id_fk FOREIGN KEY (production_cycle_id) REFERENCES production_cycles (id),
    CONSTRAINT farm_with_production_cycle_id PRIMARY KEY (farm_id, production_cycle_id)
);

INSERT INTO contracts(contract_duration_in_years,
                      number_of_young_animals_sold,
                      number_of_adult_animals_sold,
                      number_of_old_animals_sold,
                      young_animal_selling_cost,
                      adult_animal_selling_cost,
                      old_animal_selling_cost,
                      cost_of_feed_needs_to_purchased,
                      unsold_animal_forfeit)
VALUES (5,
        5,
        5,
        5,
        1000,
        2000,
        700,
        10000,
        2000);

INSERT INTO farms (animal_type,
                   farm_owner,
                   capital,
                   number_of_young_animals,
                   number_of_adult_animals,
                   number_of_old_animals,
                   contract_id)
VALUES ('COW',
        'Smorodinova Sofya Sergeevna',
        100000,
        10,
        30,
        20,
        1);

INSERT INTO production_cycles(year_number,
                              adult_animal_fertility_rate,
                              old_animal_fertility_rate,
                              young_animal_survival_rate,
                              old_animal_mortality_rate,
                              number_of_young_animals_at_the_start_of_year,
                              number_of_adult_animals_at_the_start_of_year,
                              number_of_old_animals_at_the_start_of_year,
                              number_of_young_animals_at_the_end_of_year,
                              number_of_adult_animals_at_the_end_of_year,
                              number_of_old_animals_at_the_end_of_year,
                              feed_cost_for_one_animal,
                              total_feed_cost,
                              number_of_born_animals,
                              number_of_sold_animals,
                              total_year_income,
                              total_year_expenses,
                              farm_capital)
VALUES (1,
        10,
        20,
        30,
        10,
        10,
        30,
        20,
        20,
        40,
        10,
        200,
        20000,
        40,
        60,
        100000,
        40000,
        150000);

INSERT INTO production_cycles(year_number,
                              adult_animal_fertility_rate,
                              old_animal_fertility_rate,
                              young_animal_survival_rate,
                              old_animal_mortality_rate,
                              number_of_young_animals_at_the_start_of_year,
                              number_of_adult_animals_at_the_start_of_year,
                              number_of_old_animals_at_the_start_of_year,
                              number_of_young_animals_at_the_end_of_year,
                              number_of_adult_animals_at_the_end_of_year,
                              number_of_old_animals_at_the_end_of_year,
                              feed_cost_for_one_animal,
                              total_feed_cost,
                              number_of_born_animals,
                              number_of_sold_animals,
                              total_year_income,
                              total_year_expenses,
                              farm_capital)
VALUES (2,
        10,
        20,
        30,
        10,
        20,
        20,
        40,
        40,
        40,
        80,
        200,
        25000,
        60,
        70,
        150000,
        80000,
        200000);

INSERT INTO farm_with_production_cycle(farm_id, production_cycle_id)
VALUES (1, 1);
INSERT INTO farm_with_production_cycle(farm_id, production_cycle_id)
VALUES (1, 2);
