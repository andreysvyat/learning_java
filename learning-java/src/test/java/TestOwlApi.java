import org.junit.jupiter.api.Test;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestOwlApi {

    @Test
    void testMyOntology() throws OWLOntologyCreationException, IOException {
        OWLOntologyManager m = OWLManager.createOWLOntologyManager();
        String fileName = "/home/andreysvyat/experiments/test_files/onto.rdf";
        InputStream fileIs = new FileInputStream(fileName);
        OWLOntology o = m.loadOntologyFromOntologyDocument(fileIs);
        assertNotNull(o);
    }
}
