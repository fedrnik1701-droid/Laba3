package org.example.service;

import org.example.entity.Loan;
import org.example.exception.ResourceNotFoundException;
import org.example.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoanService {

    private final LoanRepository loanRepository;

    public List<Loan> findAll() {
        return loanRepository.findAll();
    }

    public Loan findById(Long id) {
        return loanRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found with id: " + id));
    }

    public List<Loan> findByReader(Long readerId) {
        return loanRepository.findByReaderId(readerId);
    }

    public List<Loan> findByBook(Long bookId) {
        return loanRepository.findByBookId(bookId);
    }

    public List<Loan> findActive() {
        return loanRepository.findByStatus(Loan.LoanStatus.ACTIVE);
    }
}
