package co.com.ps.c24a.service;

import co.com.ps.c24a.entity.Person;
import co.com.ps.c24a.repository.PersonRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class PersonServiceImp implements PersonService{

    private final PersonRepository personRepository;

    @Override
    public Optional<Person> getPersonById(Long id) {
        return Optional.ofNullable(personRepository.findById(id).orElseThrow(() -> new RuntimeException("No encontro Registro")));
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Long id, Person person) {
        if (!personRepository.existsById(person.getId())) {
            throw  new RuntimeException("No encontre esa persona");
        }
        person.setId(id);

        return personRepository.save(person);
    }

    @Override
    public void deletePerson(Long id) {
        if (!personRepository.existsById(id)) {
            throw  new RuntimeException("No encontre esa persona");
        }
        personRepository.deleteById(id);
    }
}
